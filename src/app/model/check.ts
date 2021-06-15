import {Bid} from "./bid";
import {Client} from "./client";

export class Check{
  idChecks:bigint| undefined;
  bidDto:Bid| undefined;
  userDto:Client| undefined;
  cardNumber:string| undefined;
  info:string| undefined;
}
