package com.adds.safewomen.viewmodel

import androidx.lifecycle.ViewModel

class HomePageViewModel : ViewModel() {

//    sealed class SendMessageResult {
//        data object Success : SendMessageResult()
//        data class Error(val message: String) : SendMessageResult()
//    }
//
   fun onSOSButtonClicked(/*context: Context, phoneNumber: String, message: String, callback: (SendMessageResult) -> Unit*/) {
//        viewModelScope.launch {
//            val smsResult = sendSMS(context, phoneNumber, message)
//            val whatsappResult = sendWhatsAppMessage(context, phoneNumber, message)
//
//            if (smsResult is SendMessageResult.Error || whatsappResult is SendMessageResult.Error) {
//                callback(SendMessageResult.Error("Failed to send SOS message"))
//            } else {
//                callback(SendMessageResult.Success)
//            }
//        }
//    }
//
//    private fun sendSMS(context: Context, phoneNumber: String, message: String): SendMessageResult {
//        return try {
//            val smsManager: SmsManager = SmsManager.getDefault()
//            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
//            SendMessageResult.Success
//        } catch (e: Exception) {
//            e.printStackTrace()
//            SendMessageResult.Error(e.localizedMessage ?: "Unknown error occurred")
//        }
//    }
//
//    private fun sendWhatsAppMessage(context: Context, phoneNumber: String, message: String): SendMessageResult {
//        return try {
//            val uri = Uri.parse("smsto:$phoneNumber")
//            val intent = Intent(Intent.ACTION_SENDTO, uri)
//            intent.setPackage("com.whatsapp")
//            intent.putExtra("sms_body", message)
//            context.startActivity(intent)
//            SendMessageResult.Success
//        } catch (e: Exception) {
//            e.printStackTrace()
//            SendMessageResult.Error(e.localizedMessage ?: "Unknown error occurred")
//        }
//    }
}}

