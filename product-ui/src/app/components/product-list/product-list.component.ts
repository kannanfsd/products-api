import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  //templateUrl: './product-list.component.html',
  //templateUrl: './product-list-table.component.html',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  constructor(private productService: ProductService,
    private route: ActivatedRoute, private router: Router
  ) {}
  ngOnInit(): void {
      this.listProducts();
  }
  listProducts() {
    this.productService.getProductList().subscribe(
      data => {
        this.products = data;
      }
    )
  }
  deleteProduct(id: number) {
    console.log(`delete todo ${id}`)
    this.productService.deleteProduct(id).subscribe(
      response => {
        console.log(response);
        this.listProducts();
      }
    )
  }
  updateProduct(id: number) {
    console.log(`update ${id}`)
    this.router.navigate(['products', id])
  }
  addProduct() {
    this.router.navigate(['products', -1])
  }
}
