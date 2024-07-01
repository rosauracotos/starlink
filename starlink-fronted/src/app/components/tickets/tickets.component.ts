import { Component } from '@angular/core';
import {ApiBackendService} from "../../services/ApiBackendService/api.backend.service";
import {SweetAlertService} from "../../services/SweetAlertService/sweet.alert.service";
import {LocalStorageService} from "../../services/LocalStorageService/local.storage.service";
import {Router} from "@angular/router";
import {TicketDto} from "../../models/TicketDto";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrl: './tickets.component.css'
})
export class TicketsComponent {
  displayedColumns: string[] = ['numticket','persona','tipoticket','fechaticket', 'estadoticket', 'acciones'];
  dataSource = new MatTableDataSource<TicketDto>();

  tiposDocumentos : any[] = [];
  estadosTickets : any[] = [];
  selectedTipoDocumento: any;
  selectedEstadoTicket: any;
  nroTicket: any;
  nroDocumento: any;
  fechaInicio: string = '';
  fechaFin: string = '';

  constructor(private apiBackendService: ApiBackendService,
              private sweetAlertService: SweetAlertService,
              private localStorageService: LocalStorageService,
              private router: Router) {}

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

  redirectNuevoTicket() {
    this.localStorageService.removeItem('ticketId');
    this.localStorageService.setItem('ocultarBotonGuardar', false);
    this.router.navigate(['/ticket-formulario']);
  }

  editarTicket(ticket: TicketDto) {
    this.localStorageService.setItem('ticketId', ticket.id);
    this.router.navigate(['/ticket-formulario']);
  }

}
