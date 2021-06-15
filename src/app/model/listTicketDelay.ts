import {Ticket} from "./ticket";

export class ListTicketDelay {
  ticketDtoList: Ticket[] = [];
  countOfDelay: number| undefined;
  delay: string[] = [];
}
