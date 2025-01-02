import pandas as pd
import json
import os
import asyncio
from typing import Any, Dict, Union

class DataLoader:
    def __init__(self, file_path: str):
        self.file_path = file_path

    async def load_data(self) -> Union[pd.DataFrame, Dict[str, Any]]:
        """Load data asynchronously based on file extension."""
        ext = os.path.splitext(self.file_path)[1].lower()
        if ext == '.csv':
            return await self.load_csv()
        elif ext == '.json':
            return await self.load_json()
        else:
            raise ValueError(f"Unsupported file type: {ext}")

    async def load_csv(self) -> pd.DataFrame:
        """Load CSV data."""
        return await asyncio.to_thread(pd.read_csv, self.file_path)

    async def load_json(self) -> Dict[str, Any]:
        """Load JSON data."""
        async with await asyncio.to_thread(open, self.file_path, 'r') as f:
            return await asyncio.to_thread(json.load, f)

    @staticmethod
    def validate_data(data: Union[pd.DataFrame, Dict[str, Any]]) -> bool:
        """Validate loaded data."""
        if isinstance(data, pd.DataFrame):
            return not data.empty
        elif isinstance(data, dict):
            return bool(data)
        return False

# Example usage
# loader = DataLoader('data/sample_data.csv')
# data = asyncio.run(loader.load_data())
# print(data)
