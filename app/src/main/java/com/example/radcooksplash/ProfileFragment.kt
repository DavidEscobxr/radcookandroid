package com.example.radcooksplash

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class ProfileFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)

        val imageViewProfile = rootView.findViewById<ImageView>(R.id.imageViewProfile)
        val buttonChangeProfilePicture =
            rootView.findViewById<Button>(R.id.buttonChangeProfilePicture)
        val editTextName = rootView.findViewById<EditText>(R.id.editTextName)
        val editTextEmail = rootView.findViewById<EditText>(R.id.editTextEmail)
        val buttonSaveChanges = rootView.findViewById<Button>(R.id.buttonSaveChanges)

        buttonChangeProfilePicture.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
           //requireActivity().startActivityForResult(intent, SELECT_IMAGE_REQUEST_CODE)
        }

        buttonSaveChanges.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()

            // Realizar acciones para guardar los cambios
        }
        return rootView
    }

    //override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
      //  super.onActivityResult(requestCode, resultCode, data)
        //if (requestCode == SELECT_IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
          //  val selectedImage: Uri = data.data ?: return
        //    val imageViewProfile = requireView().findViewById<ImageView>(R.id.imageViewProfile)
          //  imageViewProfile.setImageURI(selectedImage)
        //}

   // }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
