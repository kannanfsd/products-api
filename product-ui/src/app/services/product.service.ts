import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';
import { map } from 'rxjs/operators';
import { PRODUCT_API_URL } from '../app.constant';
import { CProduct } from '../components/product/product.component';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) { }

  getProductList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${PRODUCT_API_URL}`);
  }

  getProduct(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${PRODUCT_API_URL}/${id}`)
  }

  createProduct(product: CProduct) {
    return this.httpClient.post(
      `${PRODUCT_API_URL}`
      , product);
  }

  updateProduct(id: number, product: CProduct) {
    return this.httpClient.put(
      `${PRODUCT_API_URL}/${id}`
      , product);
  }

  deleteProduct(id: number) {
    return this.httpClient.delete(`${PRODUCT_API_URL}/${id}`);
  }
}

