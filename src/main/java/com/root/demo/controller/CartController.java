package com.root.demo.controller;

import com.root.demo.controller.converter.DTOToDomainConverter;
import com.root.demo.controller.converter.DomainToDTOConverter;
import com.root.demo.controller.dto.CartDTO;
import com.root.demo.controller.dto.request.CartRQ;
import com.root.demo.controller.dto.request.CartUpdateRQ;
import com.root.demo.controller.dto.response.CartCreateRS;
import com.root.demo.controller.dto.response.CartListRS;
import com.root.demo.service.domain.result.CartCreateResult;
import com.root.demo.service.domain.result.CartDeleteResult;
import com.root.demo.service.domain.result.CartDetailResult;
import com.root.demo.service.domain.result.CartListResult;
import com.root.demo.service.domain.result.CartUpdateResult;
import com.root.demo.service.impl.CartServiceImpl;
import com.root.demo.utils.StatusCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
@Validated
@Controller
public class CartController {

    @Autowired
    private final CartServiceImpl cartService;

    @Autowired
    private DTOToDomainConverter convertToDomain;
    private DomainToDTOConverter convertToDTO;
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @GetMapping("")
    @Operation(summary = "Get all active carts", description = "Get all active carts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    public ResponseEntity<?> getAllCartActive() {
        CartListResult result = cartService.getList();
        ResponseEntity responseEntity;
        if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
            CartListRS response = convertToDTO.convert(result);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("")
    @Operation(summary = "Create new shopping cart", description = "Create a new cart with a list of products in it.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    public ResponseEntity<CartCreateRS> createCart(@RequestBody CartRQ cartRQ) {

        CartCreateResult result = cartService.createCart(convertToDomain.convert(cartRQ));
        ResponseEntity responseEntity;
        if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
            CartCreateRS response = convertToDTO.convert(result);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cart information", description = "Get cart information by generated token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(
                    schema = @Schema(implementation = CartDTO.class)
            ))
    })
    public ResponseEntity<?> getCartDetail(@PathVariable("id") String id) {
        CartDetailResult result = cartService.getDetail(id);
        ResponseEntity responseEntity;
        if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
            CartDTO response = convertToDTO.convert(result);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Put or Drop products from cart", description = "Put or Drop products from the cart.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    public ResponseEntity<?> pushDropProductToCart(@PathVariable("id") String id,
                                                    @RequestBody CartUpdateRQ cartUpdateRQ) {

        CartUpdateResult result = cartService.updateCart(convertToDomain.convert(cartUpdateRQ,id));
        ResponseEntity responseEntity;
        if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete cart", description = "Delete cart by generated token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    public ResponseEntity<?> deleteCart(@PathVariable("id") String id) {
        CartDeleteResult result = cartService.deleteCart(id);
        ResponseEntity responseEntity;
        if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
