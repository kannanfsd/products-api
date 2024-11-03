import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/common/category';
import { Product } from 'src/app/common/product';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

export class CProduct {
  constructor(
    public name: string,
    public description: string,
    public price: number,
    public quantity: number,
    public categoryId: number
  ){}
}

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit{
  id: number = 0;
  cproduct!: CProduct;
  categories: Category[] = [];
  selectedCategory: number = 0;

  constructor(
    public route: ActivatedRoute,
    public router: Router,
    public productService: ProductService,
    public categoryService: CategoryService){}

  ngOnInit(): void {
    this.listCategory();
    this.id = this.route.snapshot.params['id'];
    this.cproduct = new CProduct('', '', 0, 0, 0);
    if (this.id != -1) {
      this.listProduct();
    }
    //console.log(this.cproduct);
  }

  listProduct() {
    this.productService.getProduct(this.id).subscribe(
      data => {
        this.cproduct = data;
      }
    )
  }

  listCategory() {
    this.categoryService.getCategoryList().subscribe(
      data => {
        this.categories = data;
      }
    )
  }

  saveProduct() {
    if (this.id == -1) {
      this.cproduct.categoryId = this.selectedCategory;
      this.productService.createProduct(this.cproduct)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['products'])
          }
        )
    } else {
      this.productService.updateProduct(this.id, this.cproduct)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['products'])
          }
        )
    }
  }

  onProductChange(event: any) {
    this.selectedCategory = event.target.value;
    console.log('Selected category ID:', this.selectedCategory);
  }
}
