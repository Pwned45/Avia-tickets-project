import {Point} from "./point";
import {Plane} from "./plane";

export class Way {
  idWay: bigint;
  pointFirstDto: Point;
  pointEndDto: Point;
  planeDto: Plane;
}
