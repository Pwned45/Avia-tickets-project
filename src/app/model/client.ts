import {Location} from "./location";

export class Client{
  idUser: bigint| undefined;
  locationDto: Location| undefined;
  roles:string| undefined;
  name:string| undefined;
  lastName:string| undefined;
  bornDay:Date| undefined;
  login:string| undefined;
  pass:string| undefined;
  email:string| undefined;
  phone:bigint| undefined;
}
