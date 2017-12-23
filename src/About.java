/*  -*- indent-tabs-mode: t; tab-width: 4; c-basic-offset: 4 -*-
Twidor: the twiddler typing tutor.
Copyright (C) 2005	James Fusia
Copyright (C) 2017	Carey Richard Murphey

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
USA.
 */
/**
 * <pre>
 * About.java, program and version information.
 * </pre>
 * @author Carey Richard Murphey
 */
import java.awt.*;
import javax.swing.*;
import java.lang.String;
import java.io.*;
import java.util.Properties;

public class About extends JFrame implements TwidorConstants {

	public About() {
		Container contentPane = getContentPane();
		JPanel panel = new JPanel();
		panel.add(new JLabel("Twidor version " + Twidor.prop.getProperty("version")));
		contentPane.add(panel, BorderLayout.PAGE_START);
		
		panel = new JPanel();
		panel.add(new JLabel("<html>Twidor, a typing tutor for Twiddler<br><br>" +
							 "Copyright (C) 2005	James Fusia<br>" +
							 "Copyright (C) 2017	Carey Richard Murphey<br>" +
							 "<br>" +
							 "This program is free software; you can redistribute it and/or<br>" +
							 "modify it under the terms of the GNU General Public License<br>" +
							 "as published by the Free Software Foundation; either version 2<br>" +
							 "of the License, or (at your option) any later version.<br>" +
							 "" +
							 "This program is distributed in the hope that it will be useful,<br>" +
							 "but WITHOUT ANY WARRANTY; without even the implied warranty of<br>" +
							 "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the<br>" +
							 "GNU General Public License for more details.<br>" +
							 "<br>" +
							 "You should have received a copy of the GNU General Public License<br>" +
							 "along with this program; if not, write to the Free Software<br>" +
							 "Foundation, Inc., 51 Franklin Street, Fifth Floor," +
							 "Boston, MA  02110-1301, USA." +
							 "</html>"));
		contentPane.add(panel, BorderLayout.CENTER);
		JButton ok = new JButton("Ok");
		ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setVisible(false);
				}
			});
		panel = new JPanel();
		panel.add(ok);
		contentPane.add(panel, BorderLayout.PAGE_END);
		pack();
		setVisible(true);
	}
}
