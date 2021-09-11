export type SaleSum = {
    sellerName: string,
    sum: number
}

export type SaleSuccess = {
    sellerName: string,
    visited: number,
    deals: number
}

export type Seller = {
    id: number,
    name: string
}

export type Sale = {
    id: number,
    visited: number,
    deals: number,
    amount: number,
    date: string,
    seller: Seller
}

export type SalePage = {
    content?: Sale[];
    totalPages: number;
    totalElements: number;
    last: boolean;
    size?: number;
    number: number;
    first: boolean;
    numberOfElements?: number;
    empty?: boolean;
  }
  