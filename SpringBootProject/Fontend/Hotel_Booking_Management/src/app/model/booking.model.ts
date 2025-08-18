import { Customer } from "./customer.model";
import { Hotel } from "./hotel.model";
import { Room } from "./room.model";


export interface Booking {

    id?: number;                    // Optional, backend এ auto-generate হয়
    contractPersonName: string;
    phone: string;
    checkIn: string;                // "YYYY-MM-DD" format
    checkOut: string;               // "YYYY-MM-DD" format
    advanceAmount: number;
    totalAmount: number;
    dueAmount: number;
    numberOfRooms: number;
    customer: Customer;             // Customer object
    hotel: Hotel;                   // Hotel object
    room: Room;



}