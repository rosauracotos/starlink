import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {MatTableDataSource} from "@angular/material/table";
import {TicketEstadoDto} from "../../models/TicketEstadoDto";

@Component({
  selector: 'app-ticket-dialog',
  templateUrl: './ticket-dialog.component.html',
  styleUrl: './ticket-dialog.component.css'
})
export class TicketDialogComponent {

  displayedColumns: string[] = ['estado','fechaestado','comentario'];
  dataSource = new MatTableDataSource<TicketEstadoDto>();

  ticketId: any;

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService) {}

  ngOnInit() {
    this.ticketId = this.localStorageService.getItem("ticketId");

    this.apiBackendService.obtenerEstadosTicketPorId(this.ticketId).subscribe(
      (response) =>{
        const informacion: TicketEstadoDto[] = response.map((data: any) => new TicketEstadoDto(data));
        this.dataSource.data = informacion;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }
}
