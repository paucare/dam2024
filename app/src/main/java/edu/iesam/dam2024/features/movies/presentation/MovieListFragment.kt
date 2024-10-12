package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2024.databinding.FragmentMovieListBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieListFragment: Fragment() {

    private lateinit var factory: MovieFactory
    private lateinit var viewModel: MovieListViewModel
    private lateinit var movieAdapter: MovieAdapter

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = MovieFactory(requireContext())
        viewModel = factory.getMovieListViewModel()
        setupObserver()
        viewModel.loadMovies()
    }

    private fun setupObserver(){
        val movieDetailObserver = Observer<MovieListViewModel.UiState> { uiState ->
            uiState.movies?.let { movies ->
                bindData(movies)
            }
            uiState.errorApp?.let {
                //Pintar el error
            }
            if (uiState.isLoading){
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev"," Cargado ...")
            }
        }

        viewModel.uiState.observe(viewLifecycleOwner,movieDetailObserver)
    }

    private fun bindData(movies : List<Movie>){
        binding.apply {
            recyclerViewMovie.layoutManager = LinearLayoutManager(requireContext())
            movieAdapter = MovieAdapter(movies){
                movieId -> navigateToDetails(movieId)
            }
            recyclerViewMovie.adapter = movieAdapter

        }
    }

    private fun navigateToDetails(movieId : String){
        findNavController().navigate(MovieListFragmentDirections
            .actionMovieListToMovieDetail(movieId))

    }









}