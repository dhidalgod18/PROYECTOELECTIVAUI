package com.example.proyectoelectivaui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.proyectoelectivaui.R
import com.example.proyectoelectivaui.data.entities.usuarioEntity
import com.example.proyectoelectivaui.databinding.FragmentRegistroBinding


class RegistroFragment : Fragment() {



    private var _binding : FragmentRegistroBinding? = null

    private val binding get() = _binding!!

    private lateinit var miViewModel: RegistroViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registroFragment_to_loginFragmento)
        }
        miViewModel = ViewModelProvider(this).get(RegistroViewModel::class.java)



        view.findViewById<Button>(R.id.btnRegistro).setOnClickListener {

            val user = view.findViewById<EditText>(R.id.txtUser).text.toString()
            val pass = view.findViewById<EditText>(R.id.txtPassword).text.toString()
            println(user)
            println(pass)
            val usuario = usuarioEntity(
                user = user,
                password = pass
            )

            miViewModel.agregar(usuario)
        }


    }
}