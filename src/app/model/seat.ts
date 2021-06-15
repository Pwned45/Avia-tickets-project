import {Plane} from "./plane";

export class Seat {
  idSeat: bigint| undefined;
  planeDto: Plane| undefined;
  row: number| undefined;
  numberSeat: number| undefined;
}
