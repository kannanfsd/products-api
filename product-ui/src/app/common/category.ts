export class Category {
  constructor(
    public id: number,
    public name: string,
    public priority: number,
    public createdAt: Date,
    public updatedAt: Date
  ){}
}
