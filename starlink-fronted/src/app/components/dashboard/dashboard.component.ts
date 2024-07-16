import {Component, inject} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {TicketDto} from "../../models/TicketDto";
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {Router} from "@angular/router";
import {TicketDialogComponent} from "../ticket-dialog/ticket-dialog.component";
import {MatDialog} from "@angular/material/dialog";
import {TicketReporteComponent} from "../ticket-reporte/ticket-reporte.component";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  displayedColumns: string[] = ['numticket','persona','tipoticket','fechaticket', 'estadoticket', 'acciones'];
  dataSource = new MatTableDataSource<TicketDto>();
  pdfBase64 = '';

  tiposDocumentos : any[] = [];
  estadosTickets : any[] = [];
  selectedTipoDocumento: any;
  selectedEstadoTicket: any;
  nroTicket: any;
  nroDocumento: any;
  nombreUsuarioLogueado: any;
  fechaInicio: string = '';
  fechaFin: string = '';

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private dialog: MatDialog ) {}

  ngOnInit() {

    this.apiBackendService.obtenerTiposDocumentos().subscribe(
      (response) => {
        this.tiposDocumentos = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );

    this.apiBackendService.obtenerEstadosTickets().subscribe(
      (response) => {
        this.estadosTickets = response;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
    this.selectedTipoDocumento = this.localStorageService.getItem('tipoDocumentoId');
    this.nroDocumento = this.localStorageService.getItem('numeroDocumento');
    this.nombreUsuarioLogueado = this.localStorageService.getItem('nombreUsuarioLogueado');
    this.localStorageService.removeItem('ticketId');
    this.onSubmit();
  }

  onSubmit() {
    this.apiBackendService.busquedaPaginadaTickets(this.selectedTipoDocumento, this.nroDocumento, this.fechaInicio,
      this.fechaFin, this.selectedEstadoTicket, this.nroTicket, 100).subscribe(
      (response) =>{
        const colaboradores: TicketDto[] = response.data.map((data: any) => new TicketDto(data));
        this.dataSource.data = colaboradores;
      },
      (error) => {
        this.sweetAlertService.showAlertError("Ocurrió un error al conectar al servidor");
      }
    );
  }

  openDialog(ticket: TicketDto) {
    this.localStorageService.setItem('ticketId', ticket.id);
    const dialogRef = this.dialog.open(TicketDialogComponent);
  }

  openDialogReporte(ticket: TicketDto) {
    this.localStorageService.setItem('ticketId', ticket.id);
    const dialogRef = this.dialog.open(TicketReporteComponent,{
      width: '1200px',
    });
  }

}
