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
    if (this.files) {
      this.loading = true;
      this.files.forEach(file => {
        (this.uploadXmlFileService.upload(file)).subscribe(
          (event: any) => {
            this.loading = false;
          },
          (err: any) => {
            console.log(err);
            this.loading = false;
          });
      })
    }
    this.loading = false;
  }
}
