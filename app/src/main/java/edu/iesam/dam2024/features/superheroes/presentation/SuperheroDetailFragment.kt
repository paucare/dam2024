package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.iesam.dam2024.features.movies.presentation.MovieDetailViewModel
import edu.iesam.dam2024.features.superheroes.domain.Superhero


class SuperheroDetailFragment: Fragment() {

    private val superheroArgs : SuperheroDetailFragmentArgs by navArgs()

    private lateinit var factory: SuperheroFactory
    private lateinit var viewModel: SuperheroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = SuperheroFactory(requireContext())
        viewModel = factory.getSuperheroDetailViewModel()

        setupObserver()

        viewModel.viewCreated(superheroArgs.superheroId)

    }

    private fun setupObserver() {

        val heroDetailObserver = Observer<SuperheroDetailViewModel.UiState> { uiState ->
            uiState.superhero?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev"," Cargado ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, heroDetailObserver)
    }
    private fun bindData(hero: Superhero) {
        binding.apply {
            superheroName.text = hero.name
            superheroImage.loadUrl(hero.images.sm)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}