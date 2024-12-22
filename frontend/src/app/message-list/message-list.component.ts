import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { MessageComponent } from '../message/message.component';
import { Message, MessagePost } from '../message';
import { MessageService } from '../message.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-message-list',
  standalone: true,
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css'],
  imports: [MessageComponent, FormsModule],  
})
export class  MessageListComponent implements OnInit {
  message: MessagePost = { 
    deviceId: 0, 
    header: '', 
    message: '', 
    sentAt: new Date()
  };

  bearerToken: string = '';

  isSubmitted: boolean = false;
  errorMessage: string = '';

  messageList!: Message[];
  messageList$!: Observable<Message[]>;

  constructor(private router: Router, private messageService: MessageService) {}

  ngOnInit(): void {
    this.messageService.getMessages().subscribe((result) => {
      this.messageList = result;
    });
  }

  onSubmit() {
    this.isSubmitted = true;

    if (this.message.deviceId && this.message.header && this.message.message && this.message.sentAt) {
      if (this.bearerToken.trim() === '') {
        this.errorMessage = 'Please provide the Bearer Token.';
        return;
      }

      // Call the device service to add the device, passing the bearer token
      this.messageService.sendMessage(this.message, this.bearerToken).subscribe({
        next: (v) => {
          this.router.navigateByUrl("/messages");  // Redirect to the device list or another page
        },
        error: (e) => this.errorMessage = e.message
      });
    } else {
      this.errorMessage = 'Please fill in all required fields.';
    }
  }
}
