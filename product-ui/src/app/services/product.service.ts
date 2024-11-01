import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private baseUrl = `http://localhost:8081/products/api/fetch`;

  constructor(private httpClient: HttpClient) { }

  getProductList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`http://localhost:8081/products/api/fetch`);
  }
}

interface GetResponse {
  _embedded: {
    products: Product[];
  }
}
