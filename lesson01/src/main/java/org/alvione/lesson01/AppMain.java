/*
 * Copyright (c) 2018 DI (IoC) Container (Team: GC Dev, Owner: Maxim Ivanov) authors and/or its affiliates. All rights reserved.
 *
 * This file is part of DI (IoC) Container Project.
 *
 * DI (IoC) Container Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DI (IoC) Container Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with DI (IoC) Container Project.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.alvione.lesson01;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The main class "controller" of the application.
 *
 * @author GenCloud
 * @date 10/2018
 */
public class AppMain {
	private static final String[] BANNER = {"",
			"   _____                           __  __           _      _ ",
			"  / ____|                         |  \\/  |         | |    | |",
			" | |     ___  _   _ _ __ ___ ___  | \\  / | ___   __| | ___| |",
			" | |    / _ \\| | | | '__/ __/ _ \\ | |\\/| |/ _ \\ / _` |/ _ \\ |",
			" | |___| (_) | |_| | | | (_|  __/ | |  | | (_) | (_| |  __/ |",
			"  \\_____\\___/ \\__,_|_|  \\___\\___| |_|  |_|\\___/ \\__,_|\\___|_|"};


	/**
	 * The main function of the application is the entry point.
	 * Called when the library starts, if there is one.
	 *
	 * @param args library launch arguments from command line, fixed-length one-dimensional array
	 */
	public static void main(String[] args) {
		printBanner();
	}


	/**
	 * The function of converting an array of strings into a
	 * stream and outputting these strings to the console (on the screen).
	 */
	private static void printBanner() {
		final Stream<String> stringStream = Arrays.stream(BANNER);
		stringStream.forEach(System.out::println);
	}
}
