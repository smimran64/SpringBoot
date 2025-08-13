


export interface Hotel {
    id? : number;
    name: string;
    address: string;
    rating: string;
    image?: string;
    location: { id: number };
    hotelAdmin?: { id: number }; // optional, backend attaches automatically
}


