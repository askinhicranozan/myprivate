export class PolicyRegistrationInfo {
    description: string;
    productType: string;
    productName:string
    time: string;
    price:number;


constructor(description:string,productType:string,productName:string,time:string,price:number) {
	this.description=description;
	this.productType=productType;
	this.productName=productName;
	this.time=time;
	this.price=price
	
}
  
}