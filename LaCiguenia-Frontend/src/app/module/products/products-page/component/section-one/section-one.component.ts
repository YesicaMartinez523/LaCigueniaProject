import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoryModel } from '@commons/domains/model/category/CategoryModel';
import { ProductModel } from '@commons/domains/model/product/ProductModel';
import { GenericResponse } from '@commons/response/GenericResponse';
import { AMOUNT, CATEGORY, DESCRIPTION, CODE, NAME_PRODUCT, PRICE, SAVE, TITLE } from '@module/products/products-page/component/section-one/constans/section-one';
import { CategoriesReadUseCase } from '@repository/category/case/CategoriesReadUseCase';
import { ProductCreateUseCase } from '@repository/product/case/ProductCreateUseCase';

@Component({
  selector: 'app-section-one',
  templateUrl: './section-one.component.html',
  styleUrls: ['./section-one.component.scss']
})
export class SectionOneComponent implements OnInit {
  textTitle = TITLE;
  textNameProduct = NAME_PRODUCT;
  textPrice = PRICE;
  textCode = CODE;
  textAmount = AMOUNT;
  textCategory = CATEGORY;
  textDescription = DESCRIPTION;
  textPay = SAVE;

  productForm!: FormGroup;
  productModel!: ProductModel;
  category!: CategoryModel [];

  constructor(public formulary: FormBuilder, public router: Router, private productCreateUseCase: ProductCreateUseCase,
              private categoriesReadUseCase: CategoriesReadUseCase){
    this.productForm = formulary.group({
      nameProduct: ['', [Validators.required]],
      codeProduct: ['', [Validators.required]],
      priceProduct: ['', [Validators.required]],
      categoryProduct: ['', [Validators.required]],
      descriptionProduct: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.getCategory();
  }
  
  getCategory(){
    this.categoriesReadUseCase.execute().subscribe(
      (res: GenericResponse) => {
        this.category = res.objectResponse;
      },
      error => {
        console.error("Error en la solicitud: " + error);
      });
  }

  createProduct(){
    if (!this.productForm.valid) {
      this.productForm.markAllAsTouched();
      return;
    }

    this.productModel = {
      productCode: this.productForm.controls['codeProduct'].value,
      productName: this.productForm.controls['nameProduct'].value,
      productPrice: this.productForm.controls['priceProduct'].value,
      productDescription: this.productForm.controls['descriptionProduct'].value,
      categoryEntity: this.productForm.controls['categoryProduct'].value
    }

    this.productCreateUseCase.execute(this.productModel).subscribe(
      (genericResponse: GenericResponse) => {
        if (genericResponse.statusCode === 200) {
          this.productForm.reset();
        } else {
          alert("Producto Ya Existe");
          this.productForm.reset();
        }
      },
      (error) => {
        console.error('Error en la suscripción:', error);
        alert("Ocurrió un error al procesar la solicitud");
        this.productForm.reset();
    });
  }
}
