//----------------------------------------------------------------------------//
//                                                                            //
//                            E x p o r t T a s k                             //
//                                                                            //
//  Copyright (C) Herve Bitteur 2000-2007. All rights reserved.               //
//  This software is released under the GNU General Public License.           //
//  Contact author at herve.bitteur@laposte.net to report bugs & suggestions. //
//----------------------------------------------------------------------------//
//
package omr.script;

import omr.score.ScoreManager;

import omr.sheet.Sheet;

import omr.step.StepException;

import java.io.File;

import javax.xml.bind.annotation.*;

/**
 * Class <code>ExportTask</code> is a script task which exports score entities
 * to a MusicXML file
 *
 * @author Herv&eacute Bitteur
 * @version $Id$
 */
@XmlAccessorType(XmlAccessType.NONE)
public class ExportTask
    extends Task
{
    //~ Instance fields --------------------------------------------------------

    /** The file used for export */
    @XmlAttribute
    private String path;

    //~ Constructors -----------------------------------------------------------

    //------------//
    // ExportTask //
    //------------//
    /**
     * Create a task to export the related score entities of a sheet
     *
     * @param path the full path of the export file
     */
    public ExportTask (String path)
    {
        this.path = path;
    }

    //------------//
    // ExportTask //
    //------------//
    /** No-arg constructor needed by JAXB */
    private ExportTask ()
    {
    }

    //~ Methods ----------------------------------------------------------------

    //-----//
    // run //
    //-----//
    @Override
    public void run (Sheet sheet)
        throws StepException
    {
        ScoreManager.getInstance()
                    .export(sheet.getScore(), new File(path));
    }

    //-----------------//
    // internalsString //
    //-----------------//
    @Override
    protected String internalsString ()
    {
        return " export " + path;
    }
}