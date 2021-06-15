import {Way} from "./way";
import {Seat} from "./seat";

export class Ticket{
  idTicket:bigint| undefined;
  wayDto:Way| undefined;
  seatDto:Seat| undefined;
  startDate:Date| undefined;
  endDate:Date| undefined;
  price:bigint| undefined;
  flag:number| undefined;
}
