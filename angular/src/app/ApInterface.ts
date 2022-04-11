export class User{
    first_name: String;
    middle_name: String;
    last_name: String;
    email: String;
    password: String;
    phonenumber: String;
    dob: Date;
    gender: String;
    nationality: String;
    aadharcard: String;
    pancard: String;
}

export class Login{
    email: String;
    password: String;
}

export class Admin{
    username: String;
    password : String;
}
export class Income{
    propertylocation : String;
    propertyname : String;
    estimatedamount : number;
    employmenttype : String;
    retirementage : number;
    organizationtype : String;
    employername : String;
}

export class Loan {
    maxloanamount : number;
    interestrate : number;
    loanamount : number;
    tenure : number
}

export class Documents {
    pancard : any;
    voterId : any;
    salaryslip : any;
    loa : any;
    noc : any;
    Agreement_To_Sale : any;
    
}

export class LoanObj{
    applicationid: String;
    userid: User;
    maxloanamount: number;
    interestrate:number;
    tenure: number;
    loanamount: number;
    accno: number;
    status: String;
    applieddate: Date;
    docverificationdate: Date;
}