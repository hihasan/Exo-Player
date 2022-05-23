package com.hihasan.exoplayer.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import com.hihasan.exoplayer.listeners.DialogListener


internal class DeleteDialog : AppCompatDialogFragment() {
    private var mListner: DialogListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(activity)
        builder.setTitle("Delete")
            .setMessage("Are you sure you want to delete this file")
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                //Do nothing
            })
            .setPositiveButton("Ok",
                { dialog, which -> mListner!!.deleteFile() })
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListner = try {
            context as DialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement DialogInterface")
        }
    }
}