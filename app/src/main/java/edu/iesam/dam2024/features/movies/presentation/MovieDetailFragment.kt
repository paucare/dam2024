package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMovieDetailBinding
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superheroes.presentation.SuperheroDetailViewModel
import edu.iesam.dam2024.features.superheroes.presentation.SuperheroFactory


class MovieDetailFragment : Fragment() {

    private val movieArgs : MovieDetailFragmentArgs by navArgs()

    private lateinit var factory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        factory = MovieFactory(requireContext())
        viewModel = factory.getMovieDetailViewModel()

        setupObserver()

        viewModel.viewCreated(movieArgs.movieId)
    }

    private fun setupObserver() {

        val movieDetailObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, movieDetailObserver )
    }
    private fun bindData(movie : Movie){
        binding.apply {
            titleDetail.text=movie.title
            posterDetail.loadUrl(movie.poster)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}