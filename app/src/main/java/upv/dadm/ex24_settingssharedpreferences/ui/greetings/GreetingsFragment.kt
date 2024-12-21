/*
 * Copyright (c) 2022-2024 Universitat Politècnica de València
 * Authors: David de Andrés and Juan Carlos Ruiz
 *          Fault-Tolerant Systems
 *          Instituto ITACA
 *          Universitat Politècnica de València
 *
 * Distributed under MIT license
 * (See accompanying file LICENSE.txt)
 */

package upv.dadm.ex24_settingssharedpreferences.ui.greetings

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import upv.dadm.ex24_settingssharedpreferences.R
import upv.dadm.ex24_settingssharedpreferences.databinding.FragmentGreetingsBinding

/**
 * Displays a greetings message to the user in a given color and, optionally, an icon.
 */
// The Hilt annotation @AndroidEntryPoint is required to receive dependencies from its parent class
@AndroidEntryPoint
class GreetingsFragment : Fragment(R.layout.fragment_greetings), MenuProvider {

    // Reference to the ViewModel
    private val viewModel: GreetingsViewModel by viewModels()

    // Backing property to resource binding
    private var _binding: FragmentGreetingsBinding? = null

    // Property valid between onCreateView() and onDestroyView()
    private val binding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Get the automatically generated view binding for the layout resource
        _binding = FragmentGreetingsBinding.bind(view)

        // Update the user name in the greetings message whenever it changes
        viewModel.userName.observe(viewLifecycleOwner) { userName ->
            binding.tvGreetings.text = getString(
                R.string.greetings_message,
                userName.ifEmpty { getString(R.string.anonymous) }
            )
        }
        // Update the text color of the message according to the one selected
        viewModel.textColor.observe(viewLifecycleOwner) { color ->
            binding.tvGreetings.setTextColor(Color.parseColor(color.ifEmpty { getString(R.string.default_color) }))
        }
        // Update the visibility of the icon according to the selected option
        viewModel.isIconVisible.observe(viewLifecycleOwner) { isVisible ->
            binding.ivGreetings.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
        }

        // Add this Fragment as menu provider to the activity
        requireActivity().addMenuProvider(this@GreetingsFragment, viewLifecycleOwner)
    }

    // Populates the ActionBar with action elements
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) =
        menuInflater.inflate(R.menu.menu_settings, menu)

    // Reacts to the selection of action elements
    override fun onMenuItemSelected(menuItem: MenuItem): Boolean =
        when (menuItem.itemId) {
            R.id.settingsFragment -> {
                findNavController().navigate(R.id.settingsFragment)
                true
            }

            else -> false
        }

    override fun onDestroyView() {
        super.onDestroyView()
        // Clear resources to make them eligible for garbage collection
        _binding = null
    }

}
