import { Component, OnInit } from '@angular/core';
import { FMFileUploadService } from './fm-file-upload.service';
  
@Component({
    selector: 'fm-file-upload',
    templateUrl: './fm-file-upload.component.html',
    styleUrls: ['./fm-file-upload.component.css']
})
export class FMFileUploadComponent implements OnInit {
  
    // Variable to store shortLink from api response
    shortLink: string = "";
    loading: boolean = false; // Flag variable
    file: File = {} as File; // Variable to store file
  
    // Inject service 
    constructor(private fmFileUploadService: FMFileUploadService) { }
  
    ngOnInit(): void {
    }
  
    // On file Select
    onChange(event: any) {
        this.file = event.target.files[0];
    }
  
    // OnClick of button Upload
    onUpload() {
        this.loading = !this.loading;
        console.log(this.file);
        this.fmFileUploadService.upload(this.file).subscribe(
            (event: any) => {
                if (typeof (event) === 'object') {
  
                    // Short link via api response
                    this.shortLink = event.link;
  
                    this.loading = false; // Flag variable 
                }
            }
        );
    }
}