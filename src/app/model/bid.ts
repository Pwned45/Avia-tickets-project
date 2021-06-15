import {Conditionals} from "./conditionals";
import {Ticket} from "./ticket";

export class Bid {
  idBid: bigint| undefined;
  date: Date| undefined;
  price: bigint| undefined;
  conditionalsDtos: Conditionals[] = [];
  ticketDtos: Ticket[] = [];
}
