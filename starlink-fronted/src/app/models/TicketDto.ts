export class TicketDto {
  numticket: number;
  persona: string;
  tipoticket: string;
  fechaticket: Date;
  estadoticket: string;

  constructor(data:any) {
    this.numticket = data.numticket;
    this.persona = data.persona;
    this.tipoticket = data.tipoticket;
    this.fechaticket = data.fechaticket;
    this.estadoticket = data.estadoticket;
  }
}
