export class Product {
  constructor(
    public name: string,
    public description: string,
    public price: number,
    public quantity: number,
    public createdAt: Date,
    public updatedAt: Date
  ){}
}
