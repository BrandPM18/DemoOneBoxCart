package com.root.demo.controller;

import com.root.demo.controller.converter.DTOToDomainConverter;
import com.root.demo.controller.converter.DomainToDTOConverter;
import com.root.demo.controller.dto.ProductDTO;
import com.root.demo.controller.dto.request.ProductRQ;
import com.root.demo.controller.dto.response.ProductCreateRS;
import com.root.demo.controller.dto.response.ProductListRS;
import com.root.demo.service.domain.param.ProductDetailParam;
import com.root.demo.service.domain.result.ProductCreateResult;
import com.root.demo.service.domain.result.ProductDetailResult;
import com.root.demo.service.domain.result.ProductListResult;
import com.root.demo.service.impl.ProductServiceImpl;
import com.root.demo.utils.StatusCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/product")
@Validated
@Controller
public class ProductController {

    private final ProductServiceImpl productListUseCase;
    private DTOToDomainConverter convertToDomain;
    private DomainToDTOConverter convertToDTO;

    @GetMapping("")
    @Operation(summary = "List products", description = "List products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(
                    schema = @Schema(implementation = ProductListRS.class)
            ))
    })
    public ResponseEntity<?> findAll() {

        ProductListResult result = productListUseCase.getList();

        ResponseEntity responseEntity;
        if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
            ProductListRS response = convertToDTO.convert(result);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product information", description = "View specific product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(
                    schema = @Schema(implementation = ProductDTO.class)
            ))
    })
    public ResponseEntity<?> getProductDetail(@PathVariable("id") Integer id) {

        ProductDetailParam param = ProductDetailParam.builder()
                .id(id)
                .build();

        ProductDetailResult result = productListUseCase.getProductDetail(param);

        ResponseEntity responseEntity;
        if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
            ProductDTO response = convertToDTO.convert(result);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @Operation(summary = "Create new product", description = "Create new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(
                    schema = @Schema(implementation = ProductCreateRS.class)
            ))
    })
    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody ProductRQ productRQ) {

        ProductCreateResult result = productListUseCase.createProduct(convertToDomain.convert(productRQ));

        ResponseEntity responseEntity;
        if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
            ProductCreateRS response = convertToDTO.convert(result);
            responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
