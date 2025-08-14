export interface Hotel {
    id?: number;
    name: string;
    address: string;
    rating: string;
    image?: string;
    location: { id: number };
    locationName?: string; // view all hotels এর জন্য
    hotelAdmin?: { id: number };
}
