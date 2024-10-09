package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.databinding.FragmentSuperheroListBinding

class SuperheroListFragment: Fragment() {

    private lateinit var factory: SuperheroFactory
    private lateinit var viewModel: SuperheroListViewModel

    private var _binding: FragmentSuperheroListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = SuperheroFactory(requireContext())
        //viewModel= factory.getSuperheroListViewModel()
        setupObserver()
        viewModel.loadSuperHeroes()

    }
    private fun setupObserver(){
        val observer = Observer<SuperheroListViewModel.UiState>{
            //codigo de respuesta
        }
         viewModel.uiState.observe(viewLifecycleOwner,observer)
    }


}