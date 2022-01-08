package org.laughnman.filesplitter.models.transfer

import org.laughnman.filesplitter.models.AbstractCommand
import org.laughnman.filesplitter.models.ChunkSize
import org.laughnman.filesplitter.models.ChunkSizeConverter
import org.laughnman.filesplitter.models.ChunkSizeUnit
import picocli.CommandLine.Command
import picocli.CommandLine.Parameters
import picocli.CommandLine.Option
import java.nio.file.Path

@Command(name = "src-file", description = ["Transferring a file from the local file system."])
class FileSourceCommand : AbstractCommand() {

	@Parameters
	lateinit var filePaths: Array<Path>

	@Option(names = ["-b", "--buffer-size"], converter = [ChunkSizeConverter::class],
		description = ["The size of the buffer. Default is 4KB. Format is in <numeric size>B|KB|MB|GB|TB."])
	var bufferSize = ChunkSize(4, ChunkSizeUnit.KB)

}