import { HttpClient, HttpEventType, HttpResponse } from '@angular/common/http';
import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import * as $ from 'jquery';
import { Observable } from 'rxjs';
import { Documents, Income, Loan } from '../ApInterface';
import { ApplicationserviceService } from '../applicationservice.service';
import { LogUser } from '../loginservice.service';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.css']
})
export class ApplicationComponent implements OnInit {

  loanform: FormGroup;
  incomeform: FormGroup;
  uploadForm: FormGroup;
  loan: Loan;
  income: Income;
  documents: Documents;

  selectedFiles: FileList;
  progressInfos = [];
  message = '';

  fileInfos: Observable<any>;


  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router, private loguser: LogUser, private applicationService: ApplicationserviceService) { }

  ngOnInit(): void {

    if (this.loguser.logged == false) {
      this.router.navigate(['/'])
    }

    this.loanform = new FormGroup({
      maxloanamount: new FormControl(),
      interestrate: new FormControl(),
      loanamount: new FormControl(),
      tenure: new FormControl(),

    })

    this.incomeform = new FormGroup({
      propertylocation: new FormControl(),
      propertyname: new FormControl(),
      estimatedamount: new FormControl(),
      employmenttype: new FormControl(),
      retirementage: new FormControl(),
      organizationtype: new FormControl(),
      employername: new FormControl(),

    })

    this.uploadForm = this.formBuilder.group({
      docs: ['']
    });

    $(document).ready(function () {

      var current_fs, next_fs, previous_fs; //fieldsets
      var opacity;

      $(".next").click(function () {

        current_fs = $(this).parent();
        next_fs = $(this).parent().next();

        //Add Class Active
        $("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

        //show the next fieldset
        next_fs.show();
        //hide the current fieldset with style
        current_fs.animate({ opacity: 0 }, {
          step: function (now) {
            // for making fielset appear animation
            opacity = 1 - now;

            current_fs.css({
              'display': 'none',
              'position': 'relative'
            });
            next_fs.css({ 'opacity': opacity });
          },
          duration: 600
        });
      });

      $(".previous").click(function () {

        current_fs = $(this).parent();
        previous_fs = $(this).parent().prev();

        //Remove class active
        $("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

        //show the previous fieldset
        previous_fs.show();

        //hide the current fieldset with style
        current_fs.animate({ opacity: 0 }, {
          step: function (now) {
            // for making fielset appear animation
            opacity = 1 - now;

            current_fs.css({
              'display': 'none',
              'position': 'relative'
            });
            previous_fs.css({ 'opacity': opacity });
          },
          duration: 600
        });
      });

      $('.radio-group .radio').click(function () {
        $(this).parent().find('.radio').removeClass('selected');
        $(this).addClass('selected');
      });

      $(".submit").click(function () {
        return true;
      })

    });



  }
  title = 'homeloan';
  isShow = false;

  toggleDisplay() {
    this.isShow = !this.isShow;
  }

  application(): void {
    this.router.navigate(['/application/' + this.loguser.userid])

  }

  home(): void {
    this.router.navigate(['/home'])
  }

  apply(): void {
    this.router.navigate(['/apply/' + this.loguser.userid])
  }
  logout(): void {
    this.loguser.logged = false;
    this.loguser.userid = 0;
    this.router.navigate(['/login'])
  }
  saveloan(): void {

    this.loan = this.loanform.value;
    this.applicationService.saveloan(this.loan, this.loguser.userid).subscribe((data) => {
      console.log(data);
      if (data == "saved") {
        (<HTMLInputElement>document.getElementById("next1")).disabled = false;
      }
    });
  }

  saveincome(): void {

    this.income = this.incomeform.value;
    this.applicationService.saveincome(this.income, this.loguser.userid).subscribe((data) => {
      console.log(data);
      if (data == "saved") {
        (<HTMLInputElement>document.getElementById("next2")).disabled = false;
      }
    });
  }

  file: any;

  uploadfiles(event): void {
    if (event.target.files.length > 0) {
      this.file = null;
      this.file = event.target.files[0];
      this.uploadForm.get('docs').setValue(this.file);
    }
  }
  pan(): void {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('docs').value);
    this.http.post('http://localhost:8089/homeloan/documents/pancard/' + this.loguser.userid, formData, { responseType: 'text' }).subscribe((data) => {
      console.log(data);
    });
  }
  voterid(): void {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('docs').value);
    this.http.post('http://localhost:8089/homeloan/documents/voterid/' + this.loguser.userid, formData, { responseType: 'text' }).subscribe((data) => {
      console.log(data);
    });
  }
  salarys(): void {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('docs').value);
    this.http.post('http://localhost:8089/homeloan/documents/salaryslip/' + this.loguser.userid, formData, { responseType: 'text' }).subscribe((data) => {
      console.log(data);
    });
  }
  loa(): void {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('docs').value);
    this.http.post('http://localhost:8089/homeloan/documents/loa/' + this.loguser.userid, formData, { responseType: 'text' }).subscribe((data) => {
      console.log(data);
    });
  }
  noc(): void {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('docs').value);
    this.http.post('http://localhost:8089/homeloan/documents/noc/' + this.loguser.userid, formData, { responseType: 'text' }).subscribe((data) => {
      console.log(data);
    });
  }
  ats(): void {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('docs').value);
    this.http.post('http://localhost:8089/homeloan/documents/ats/' + this.loguser.userid, formData, { responseType: 'text' }).subscribe((data) => {
      console.log(data);
    });
  }


  uploaded = "UPLOADED: ";
  notuploaded = "NOT UPLOADED: ";
  generatechecklist(): void {
    this.uploaded = "UPLOADED: ";
    this.notuploaded = "NOT UPLOADED: ";
    this.applicationService.generatechecklist(this.loguser.userid).subscribe((data) => {
      console.log(data);
      console.log(typeof data[0]);
      (<HTMLInputElement>document.getElementById("uploaded")).hidden = false;
      (<HTMLInputElement>document.getElementById("notuploaded")).hidden = false;

      if (data[0][0] != null) {
        this.uploaded = this.uploaded + " Pancard, "
      }
      else if (data[0][0] == null) {
        this.notuploaded = this.notuploaded + " Pancard, "
      }

      if (data[0][1] != null) {
        this.uploaded = this.uploaded + " Voter Id, "
      }
      else if (data[0][1] == null) {
        this.notuploaded = this.notuploaded + " Voter Id, "
      }

      if (data[0][2] != null) {
        this.uploaded = this.uploaded + " Salary Slip, "
      }
      else if (data[0][2] == null) {
        this.notuploaded = this.notuploaded + " Salary Slip, "
      }

      if (data[0][3] != null) {
        this.uploaded = this.uploaded + " LOA, "
      }
      else if (data[0][3] == null) {
        this.notuploaded = this.notuploaded + " LOA, "
      }

      if (data[0][4] != null) {
        this.uploaded = this.uploaded + " NOC, "
      }
      else if (data[0][4] == null) {
        this.notuploaded = this.notuploaded + " NOC, "
      }

      if (data[0][5] != null) {
        this.uploaded = this.uploaded + " Agreement to Sale, "
      }
      else if (data[0][5] == null) {
        this.notuploaded = this.notuploaded + " Agreement to Sale, "
      }
    });
  }



}