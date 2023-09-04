import { Component } from '@angular/core';


import { HttpEventType, HttpResponse } from '@angular/common/http';
import { UploadXmlFileService } from 'src/app/service/upload-xml-file.service';

@Component({
  selector: 'app-upload-xml-file',
  templateUrl: './upload-xml-file.component.html',
  styleUrls: ['./upload-xml-file.component.css']
})
export class UploadXmlFileComponent {

  files: File[] = [];
  currentFile!: File;
  fileName: String[] = [];
  progressUpload = 0;
  message = '';
  loading: boolean = false;

  constructor(private uploadXmlFileService: UploadXmlFileService) { }


  selectFile(event: any): void{

      if(event.target.files){
         
        var extention = event.target.files[0].name.split(".").pop();

        if(extention === 'XML' || extention === 'xml'){
          this.files?.push(event.target.files[0]);
          this.fileName.push(event.target.files.name)
        }else{
          console.log('apenas arquivos xml')
        }
      }
  }

  upload(): void {
    this.progressUpload = 0;
    this.message = "";
    this.loading = true;
    if (this.files) {

      this.files.forEach(file => {
        (this.uploadXmlFileService.upload(file)).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progressUpload = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;
            }
          },
          (err: any) => {
            console.log(err);
            this.progressUpload = 0;
  
            if (err.error && err.error.message) {
              this.message = err.error.message;
            } else {
              this.message = 'Could not upload the file!';
            }
          });
      })
    }
    this.loading = false;
  }
}
