

export interface Hotel {
    id: number;
    name: string;
    image: string;
    address: string;
    maximumPrice: number;
    minimumPrice: number;
    rating: string;
    hotel_admin_id: number;

    location: {

        id: number;
        name: string;
        image: string;

    },

    


}
