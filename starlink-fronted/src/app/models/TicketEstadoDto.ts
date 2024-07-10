export class TicketEstadoDto {
  comentario: string;
  fechaestado: Date;
  estado: string;

  constructor(data:any) {
    this.comentario = data.comentario;
    this.fechaestado = data.fechaestado;
    this.estado = data.estado;
  }
}
