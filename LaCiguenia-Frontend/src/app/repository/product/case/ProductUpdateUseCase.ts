import { UseCase } from "@commons/helpers/UserCase";
import { ProductModel } from "@commons/domains/model/product/ProductModel";
import { ProductRepository } from "@repository/product/ProductRepository";
import { Observable } from "rxjs";
import { GenericResponse } from "@commons/response/GenericResponse";

export class ProductUpdateUseCase implements UseCase<ProductModel, GenericResponse>{

    constructor(private productRepository: ProductRepository){}

    execute(productModel: ProductModel) : Observable<GenericResponse>{
        return this.productRepository.updateProduct(productModel);
    }
}