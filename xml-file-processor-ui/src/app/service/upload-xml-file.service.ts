import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadXmlFileService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }
  upload(myFile: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', myFile);

    const req = new HttpRequest('POST', `${this.baseUrl}/upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }
}
