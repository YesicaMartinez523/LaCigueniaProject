package LaCiguenia.webApi.category.implement;

import LaCiguenia.commons.constans.endpoints.category.ICategoryEndPoint;
import LaCiguenia.commons.constans.response.user.IUserResponse;
import LaCiguenia.commons.domains.dto.category.CategoryDTO;
import LaCiguenia.commons.domains.responseDTO.GenericResponseDTO;
import LaCiguenia.service.category.implement.CategoryService;
import LaCiguenia.webApi.category.ICategoryApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ICategoryEndPoint.BASE_URL_CATEGORY)
@Tag(name = "Sistema de Gestión de Categorias", description = "Ops de autenticar, crear, eliminar y actualizar Categorias")
@Log4j2
public class CategoryApi implements ICategoryApi {

    private final CategoryService categoryService;

    public CategoryApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @Operation(summary = "crear una nueva categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.AUTENTIFICATION_SUCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.AUTENTIFICACION_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IUserResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PostMapping(ICategoryEndPoint.CREATE_CATEGORY)
    public ResponseEntity<GenericResponseDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        System.out.println("prueba Datos: " + categoryDTO.getCategoryId());
        return this.categoryService.createCategory(categoryDTO);
    }

    @Override
    @Operation(summary = "leer una categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.AUTENTIFICATION_SUCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.AUTENTIFICACION_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IUserResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(ICategoryEndPoint.READ_CATEGORY)
    public ResponseEntity<GenericResponseDTO> readCategory(@RequestBody CategoryDTO categoryDTO) {
        return this.categoryService.readCategory(categoryDTO);
    }

    @Override
    @Operation(summary = "leer todas las categorias")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.AUTENTIFICATION_SUCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.AUTENTIFICACION_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IUserResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @GetMapping(ICategoryEndPoint.READ_CATEGORIES)
    public ResponseEntity<GenericResponseDTO> readCategories() {
        return this.categoryService.readCategories();
    }

    @Override
    @Operation(summary = "Actualizar una categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.AUTENTIFICATION_SUCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.AUTENTIFICACION_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IUserResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @PutMapping(ICategoryEndPoint.UPDATE_CATEGORY)
    public ResponseEntity<GenericResponseDTO> updateCategory(CategoryDTO categoryDTO) {
        return this.categoryService.updateCategory(categoryDTO);
    }

    @Override
    @Operation(summary = "Eliminar una categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = IUserResponse.AUTENTIFICATION_SUCESS,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponseDTO.class))}),
            @ApiResponse(responseCode  = "400", description = IUserResponse.AUTENTIFICACION_FAIL,
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode  = "404", description = IUserResponse.NOT_FOUND,
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode  = "500", description = IUserResponse.INTERNAL_SERVER,
                    content = {@Content(mediaType = "application/json")})})
    @DeleteMapping(ICategoryEndPoint.DELETE_CATEGORY)
    public ResponseEntity<GenericResponseDTO> deleteCategory(CategoryDTO categoryDTO) {
        return this.categoryService.deleteCategory(categoryDTO);
    }
}