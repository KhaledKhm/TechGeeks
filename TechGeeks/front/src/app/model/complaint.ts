import { Type } from "./type";
import { User } from "./user"

export class Complaint {
    idComplaint:any
    title:any
    response:any
    type!:Type;
    description:any
    userComplaint:User //yaamer complaint
	exper:User //expert ili chyakrmha 
}
