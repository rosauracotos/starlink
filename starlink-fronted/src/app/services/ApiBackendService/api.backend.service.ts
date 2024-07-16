import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {LocalStorageService} from "../LocalStorageService/local.storage.service";
import {Observable} from "rxjs";
import {environment} from "../../../environments/enviroment";
import {Utilidades} from "../../../utils/utilidades";

@Injectable({
  providedIn: 'root'
})
export class ApiBackendService {
  constructor(private http: HttpClient,
              private localStorageService: LocalStorageService) { }

  obtenerTiposDocumentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/tipoDocumento/listar`, { headers: headers });
  }

  obtenerEstadosTickets(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ticketEstado/listar`, { headers: headers });
  }

  obtenerEstadosTicketsLibresPorTicket(ticketId: any): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ticketEstado/listarlibresPorTicket/` + ticketId, { headers: headers });
  }

  obtenerTiposTickets(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ticketTipo/listar`, { headers: headers });
  }

  obtenerDepartamentos(): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoDepartamento/listar`, { headers: headers });
  }

  obtenerProvinciasPorDepartamento(departamentoId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoProvincia/departamento/`+ departamentoId, { headers: headers });
  }

  obtenerDistrirosPorProvincia(provinciaId: number): Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ubigeoDistrito/provincia/`+ provinciaId, { headers: headers });
  }

  busquedaPaginadaTickets(selectedTipoDocumento: string, nroDocumento:string, fechaInicio: string, fechaFin:string ,
                          selectedEstadoTicket: any, nroTicket:any, max: number): Observable<any> {
    const body = {
      tipoDocumentoId: Utilidades.esNullOUndefinedoVacio(selectedTipoDocumento) ? null : selectedTipoDocumento,
      numeroDocumento: Utilidades.esNullOUndefinedoVacio(nroDocumento) ? null : nroDocumento,
      fechaInicio: Utilidades.esNullOUndefinedoVacio(fechaInicio) ? null : fechaInicio,
      fechaFin: Utilidades.esNullOUndefinedoVacio(fechaFin) ? null : fechaFin,
      estadoTicketId: Utilidades.esNullOUndefinedoVacio(selectedEstadoTicket) ? null : selectedEstadoTicket,
      nroTicket: Utilidades.esNullOUndefinedoVacio(nroTicket) ? null : nroTicket,
      max: max,
      limite: 0,
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/ticket/busquedaPagina`, body, { headers: headers });
  }

  buscarPersonaPorDocumento(nroDocumento: string, tipoDocumento: number): Observable<any> {
    const params = new HttpParams()
      .set('nroDocumento', nroDocumento)
      .set('tipodocumento', tipoDocumento);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/persona/buscarNroDocumento`, { params: params, headers: headers });
  }

  guardarTicket(personaId: number, direccion: string, ticketTipoSeleccionado: number, descripcion: string): Observable<any> {
    const body = {
      persona: {
        id: personaId,
        direccion: direccion
      },
      ticketTipo: {
        id: ticketTipoSeleccionado
      },
      asunto: descripcion
    };
    console.log(body);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/ticket/guardar`, body, { headers: headers });
  }

  editarTicket(tickectId:number, personaId: number, direccion: string, ticketTipoSeleccionado: number, descripcion: string): Observable<any> {
    const body = {
      persona: {
        id: personaId,
        direccion: direccion
      },
      ticketTipo: {
        id: ticketTipoSeleccionado
      },
      asunto: descripcion
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.put<any>(environment.apiUrl +`api/ticket/editar/` + tickectId, body, { headers: headers });
  }

  guardarGestionTicket(ticketId: number, comentario: string, estadoTicketSeleccionado: number): Observable<any> {
    const body = {
      ticket: {
        id: ticketId
      },
      ticketEstado: {
        id: estadoTicketSeleccionado
      },
      comentario: comentario
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/ticketGestion/guardarGestion`, body, { headers: headers });
  }

  obtenerTicketPorId(ticketId: number):Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ticket/buscar/`+ ticketId, { headers: headers });
  }

  obtenerEstadosTicketPorId(ticketId: number):Observable<any> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.get<any>(environment.apiUrl +`api/ticketGestion/ticket/`+ ticketId, { headers: headers });
  }

  visualizarReportePDF(ticket: number): Observable<Blob> {

    const params = new HttpParams()
      .set('reportName', "ticket_seguimiento")
    const body = {
      ticketid: ticket
    };
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<any>(environment.apiUrl +`api/reports/generate`, body,{ headers: headers, params: params,  responseType: 'blob' as 'json' });
  }


}
