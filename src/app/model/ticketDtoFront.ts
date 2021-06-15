import {Way} from "./way";
import {Seat} from "./seat";

export class TicketDtoFront{
  idTicket:bigint;
  wayDto:Way;
  seatDto:Seat;
  startDate:string;
  endDate:string;
  price:bigint;
  flag:number;
}
