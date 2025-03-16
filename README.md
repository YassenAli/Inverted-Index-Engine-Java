# Inverted Index Search Engine

[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/)

A Java-based inverted index implementation for building a search engine that processes text files and answers multi-keyword queries using boolean retrieval.

## 📖 Project Description
This project constructs an **inverted index** from a directory of text files and supports querying for documents containing all specified keywords. It includes:
- Index construction with stop-word filtering and stemming.
- Posting list intersection for boolean AND queries.
- File storage/loading for persistent indexes.
- Interactive query interface.

## ✨ Features
- **Inverted Index Construction**: Parses text files, removes stop words, and builds an efficient index.
- **Query Processing**: Returns documents containing **all** query keywords using optimized posting list intersections.
- **Stop Word Handling**: Filters common words (e.g., "the", "and").
- **File Persistence**: Save/load indexes to/from disk.
- **Interactive CLI**: Test queries through a command-line interface.

## 🙌 Acknowledgments
- Course: Information Retrieval (FCAI-CU).
- Inspired by classic IR textbook implementations.